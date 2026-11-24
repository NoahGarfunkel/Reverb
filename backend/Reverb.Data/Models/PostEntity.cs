namespace Reverb.Data.Models;

public class PostEntity
{
    public int Id { get; set; }
    public required string Username { get; set; }
    public DateTime Time { get; set; }
    public required string Body { get; set; }
    public int Likes { get; set; }
}