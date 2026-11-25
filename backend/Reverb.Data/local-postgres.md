# Local PostgreSQL setup

## PostgreSQL and pgAdmin

1. Install PostgreSQL and pgAdmin, and start the local PostgreSQL server. During
   PostgreSQL setup, choose a password for the local `postgres` role. This is
   your own local account and password, not a shared project credential.
2. Open pgAdmin and connect to the local server. If it is not already registered,
   right-click **Servers** > **Register** > **Server**. Give it a name and, on
   the **Connection** tab, enter `localhost`, port `5432` (or your configured
   port), username `postgres`, and your local password.
3. Expand the server, right-click **Databases** > **Create** > **Database**,
   name it `reverb`, and save.

## API connection and tables

1. In `backend\backend.slnx`, right-click **Reverb.Api** > **Manage User Secrets**.
   Add the following entry to the JSON object, replacing the password with your
   own and adjusting the port if necessary. Preserve any other entries.

   ```json
   "ConnectionStrings:ReverbDb": "Host=localhost;Port=5432;Database=reverb;Username=postgres;Password=YOUR_LOCAL_PASSWORD"
   ```

   Use JSON escaping and connection-string quoting as needed for special
   characters. User Secrets are for development and are not encrypted; do not
   commit credentials.
2. Run the existing migrations in the Visual Studio Package Manager Console:

   ```powershell
   Update-Database -Project Reverb.Data -StartupProject Reverb.Api -Args '--environment Development'
   ```

   This applies the existing migrations, including `InitialCreate`; no new
   migration is needed.
