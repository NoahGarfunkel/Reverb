namespace Reverb.Api.Models;

public record Post(string Username, DateTime Time, string Body, int Likes);