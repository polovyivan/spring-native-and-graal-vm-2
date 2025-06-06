<#
  .SYNOPSIS
  Scales kubernetes deployment, waits for scaling activity to finish and prints time required for scaling activity to complete.

  .PARAMETER deploymentName
  Specifies name of deployment which should be scaled.

  .PARAMETER replicas
  Specifies desired number of replicas to reach.

  .EXAMPLE
  PS> .\kubectl-scale-and-wait.ps1 -deploymentName microservice-products-spring-boot-regular -replicas 20
#>

param(
    [string] $deploymentName,
    [int] $replicas
)

if ($PSBoundParameters.Count -lt 2) {
    Get-Help $MyInvocation.MyCommand.Definition
    exit 1
}

function ScaleDeployment {
    Write-Output "Scaling deployment ""$deploymentName"" to $replicas replicas"

    kubectl scale --replicas=$replicas deployment $deploymentName

    if (!$?) {
        Write-Error -Message "Non-zero exit code $LastExitCode was returned from kubectl when trying to scale ""$deploymentName"" to $replicas replicas" -ErrorAction Stop
    }
}

function GetAvailableReplicasCount { 
    $availableReplicas = (kubectl get deployment $deploymentName -o template --template="{{.status.availableReplicas}}") -as [int]
    
    return $availableReplicas
}

function GetReadyReplicaCount { 
    $readyReplicaCount = (kubectl get deployment $deploymentName -o template --template="{{.status.readyReplicas}}") -as [int]
    
    return $readyReplicaCount
}

function WaitForScalingToFinish {
    Write-Output "Waiting for deployment ""$deploymentName"" to reach $replicas replicas..."

    $availableReplicas = GetAvailableReplicasCount
    $readyReplicaCount = GetReadyReplicaCount

    while ($availableReplicas -ne $replicas -or $readyReplicaCount -ne $replicas) {
        $availableReplicas = GetAvailableReplicasCount
        $readyReplicaCount = GetReadyReplicaCount

        Write-Output "Current available replica count = $availableReplicas, ready replica count = $readyReplicaCount, desired replica count = $replicas"

        Start-Sleep -Seconds 1
    }

    Write-Output "Deployment ""$deploymentName"" reached $replicas replicas..."
}

ScaleDeployment
Measure-Command { WaitForScalingToFinish | Out-Default }
