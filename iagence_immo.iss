[Setup]
AppName=agence_immo
AppVersion=1.0
DefaultDirName={pf}\agence_immo
DefaultGroupName=agence_immo
OutputDir=.
OutputBaseFilename=agence_immo_Setup
Compression=lzma
SolidCompression=yes
WizardStyle=modern

[Files]
Source: "agence_immo.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "lib\*"; DestDir: "{app}\lib"; Flags: ignoreversion recursesubdirs createallsubdirs

[Icons]
Name: "{group}\agence_immo"; \
Filename: "javaw.exe"; \
Parameters: "-cp ""{app}\agence_immo.jar;{app}\lib\*"" forms.UtilisateurForm"

Name: "{group}\Uninstall agence_immo"; Filename: "{uninstallexe}"

[Run]
Filename: "javaw.exe"; \
Parameters: "-cp ""{app}\agence_immo.jar;{app}\lib\*"" forms.UtilisateurForm"; \
Description: "Lancer agence_immo"; \
Flags: nowait postinstall skipifsilent