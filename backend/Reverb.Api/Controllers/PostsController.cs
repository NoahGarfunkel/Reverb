using Microsoft.AspNetCore.Mvc;
using Reverb.Api.Models;

namespace Reverb.Api.Controllers;

[ApiController]
[Route("posts")]
public class PostsController : ControllerBase
{
    [HttpGet]
    public ActionResult<IEnumerable<Post>> Get()
    {
        return Ok(new[]
        {
            new Post("@acegickmo", DateTimeOffset.UtcNow, "First post", 10),
            new Post("@acegickmo", DateTimeOffset.UtcNow, "Second post", 100)
        });
    }
}