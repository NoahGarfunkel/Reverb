using Microsoft.AspNetCore.Mvc;
using Reverb.Api.Models;
using Reverb.Api.Services;

namespace Reverb.Api.Controllers;

[ApiController]
[Route("posts")]
public class PostsController(PostsService postsService) : ControllerBase
{
    [HttpGet]
    public async Task<ActionResult<IEnumerable<Post>>> Get(
        [FromQuery] string? username,
        CancellationToken cancellationToken)
    {
        var posts = await postsService.GetPostsAsync(username, cancellationToken);
        return Ok(posts);
    }
}