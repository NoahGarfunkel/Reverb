using Microsoft.EntityFrameworkCore;
using Reverb.Data.Models;

namespace Reverb.Data;

public class ReverbDbContext(DbContextOptions<ReverbDbContext> options)
    : DbContext(options)
{
    public DbSet<PostEntity> Posts => Set<PostEntity>();
}