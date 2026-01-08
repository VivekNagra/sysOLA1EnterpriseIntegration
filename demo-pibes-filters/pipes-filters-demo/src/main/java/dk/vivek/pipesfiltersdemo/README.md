# Pipes & Filters Demo (Spring Boot)

## Run
```powershell
.\gradlew.bat bootRun
```
App runs on http://localhost:8080.

##Test
PowerShell (recommended):
```powershell
$body = @{
  orderId    = "O-1001"
  customerId = "C-77"
  quantity   = 120
  item       = "  usb cable  "
} | ConvertTo-Json

Invoke-RestMethod -Method Post `
  -Uri "http://localhost:8080/api/process" `
  -ContentType "application/json" `
  -Body $body
```
Expected behavior:
- item is normalized (trim + uppercase)
- riskLevel is derived from quantity
