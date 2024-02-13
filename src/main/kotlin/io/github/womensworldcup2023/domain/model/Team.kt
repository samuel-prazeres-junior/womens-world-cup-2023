package io.github.womensworldcup2023.domain.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity(name = "tb_team")
class Team (

    @Id
    @Column(nullable = false, length = 3)
    var id: String,

    @Column(nullable = false, length = 50)
    var name: String,

    @Column(nullable = false, precision = 6, scale = 2)
    var score: BigDecimal
)