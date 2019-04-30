package io.horizontalsystems.feeratekit

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import io.horizontalsystems.feeratekit.storage.EnumConverter

@Entity
@TypeConverters(EnumConverter::class)

data class FeeRate(
    @PrimaryKey
    val coin: Coin,
    val lowPriority: Long,
    val mediumPriority: Long,
    val highPriority: Long,
    val date: Long
)

enum class Coin(val code: String) {
    BITCOIN("BTC"),
    BITCOIN_CASH("BCH"),
    ETHEREUM("ETH");

    fun defaultRate(): FeeRate {
        return when (this) {
            BITCOIN -> FeeRate(
                coin = this,
                lowPriority = 20,
                mediumPriority = 40,
                highPriority = 80,
                date = 1543211299
            )
            BITCOIN_CASH -> FeeRate(
                coin = this,
                lowPriority = 1,
                mediumPriority = 3,
                highPriority = 5,
                date = 1543211299
            )
            ETHEREUM -> FeeRate(
                coin = this,
                lowPriority = 13_000_000_000,
                mediumPriority = 16_000_000_000,
                highPriority = 19_000_000_000,
                date = 1543211299
            )
        }
    }
}