using Microsoft.EntityFrameworkCore;
using Reverb.Api.Models;
using Reverb.Data;

namespace Reverb.Api.Services;

public class PostsService(ReverbDbContext dbContext)
{
    public Task<List<Post>> GetPostsAsync(string? username, CancellationToken cancellationToken)
    {
        return dbContext.Posts
            .Where(post => username == null || post.Username == username)
            .OrderByDescending(post => post.Time)
            .ThenByDescending(post => post.Id)
            .Select(post => new Post(post.Username, post.Time, post.Body, post.Likes))
            .ToListAsync(cancellationToken);
    }
}
