package io.github.womensworldcup2023.service

import io.github.womensworldcup2023.domain.model.Team

interface SimulateService {
    fun simulate(team1Id: String, team2Id: String): Team

}