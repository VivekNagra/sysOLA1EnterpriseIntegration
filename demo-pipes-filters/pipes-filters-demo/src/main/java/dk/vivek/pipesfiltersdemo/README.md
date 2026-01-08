# Pipes & Filters Demo (Spring Boot)

## Run
Requirements:
- JDK 21 installed

Start the application:
```powershell
.\mvnw.cmd spring-boot:run
```
App runs on http://localhost:8080.
now open ANOTHER terminal window and run the test (you can just copy and paste the powersheeeell commands below) 

## Test, please make sure 
PowerShell:
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
- item is normalized
- riskLevel is derived from quantity
