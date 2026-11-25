# Local HTTPS

Windows and Android emulator setup.

## 1. Create a certificate

Install [mkcert](https://github.com/FiloSottile/mkcert#windows), then run in
PowerShell:

```powershell
mkcert -install
mkcert -pkcs12 -p12-file "$env:USERPROFILE\reverb.p12" localhost 10.0.2.2
```

Approve the trust prompt.

## 2. Configure the API

From the repository root in PowerShell, configure the API User Secrets:

```powershell
dotnet user-secrets set 'Kestrel:Certificates:Default:Path' "$env:USERPROFILE\reverb.p12" --project .\backend\Reverb.Api
dotnet user-secrets set 'Kestrel:Certificates:Default:Password' 'changeit' --project .\backend\Reverb.Api
```

`$env:USERPROFILE` resolves automatically; no replacement is needed.
`changeit` is the fixed password for the mkcert bundle created above.

## 3. Configure Android debug trust

Copy your local CA certificate from the repository root:

```powershell
New-Item -ItemType Directory -Force .\android\app\src\debug\res\raw | Out-Null
Copy-Item "$(mkcert -CAROOT)\rootCA.pem" .\android\app\src\debug\res\raw\local_ca.pem
```
