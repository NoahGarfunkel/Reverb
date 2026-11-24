using Microsoft.EntityFrameworkCore;
using Reverb.Api.Services;
using Reverb.Data;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddControllers();

builder.Services.AddOpenApi();

var connectionString = builder.Configuration.GetConnectionString("ReverbDb")
    ?? throw new InvalidOperationException("Connection string 'ReverbDb' not found.");

builder.Services.AddDbContext<ReverbDbContext>(options =>
    options.UseNpgsql(connectionString));
builder.Services.AddScoped<PostsService>();

var app = builder.Build();

if (app.Environment.IsDevelopment())
{
    app.MapOpenApi();

    app.UseSwaggerUI(options =>
    {
        options.SwaggerEndpoint("/openapi/v1.json", "v1");
    });
}

app.UseHttpsRedirection();

app.MapControllers();

app.Run();
