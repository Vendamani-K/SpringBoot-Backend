# Externalized Configuration – Assignment Results

## 1. YAML Configuration
The default mail port is configured as `587` in `application.yml`.

## 2. Environment Variable Override
I set `APP_MAIL_PORT=2525` in PowerShell.

Spring Boot used `2525` instead of the YAML value `587`.

## 3. Command-Line Argument Override
I passed `--app.mail.port=2020` while starting the application.

Spring Boot used `2020` instead of `2525`.

## 4. Configuration Precedence

For the three sources tested, the priority is:

1. Command-line arguments – highest priority.
2. Environment variables.
3. application.yml – lowest priority.

## 5. Conclusion
Spring Boot supports externalized configuration. We can change application settings without modifying Java code or the YAML file.