namespace Reverb.Api.Models;

public record Post(string Username, DateTimeOffset Time, string Body, int Likes);