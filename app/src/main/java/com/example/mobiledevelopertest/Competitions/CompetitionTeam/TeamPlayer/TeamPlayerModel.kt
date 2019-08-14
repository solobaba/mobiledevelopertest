package com.example.mobiledevelopertest.Competitions.CompetitionTeam.TeamPlayer

data class TeamPlayerModel(
    var id: Int,
    var teamLogoUrl: String,
    var teamName: String,
    var playerNames: List<String>,
    var playerRoles: List<String>,
    var playerShirt: List<String>
)