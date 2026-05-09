package com.pixora.core.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "media_assets")
data class MediaAssetEntity(@PrimaryKey val id: String, val uri: String, val kind: String, val displayName: String, val capturedAtMillis: Long?)

@Dao
interface MediaAssetDao {
    @Query("SELECT * FROM media_assets ORDER BY capturedAtMillis DESC")
    fun observeAssets(): Flow<List<MediaAssetEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(assets: List<MediaAssetEntity>)
}

@Database(entities = [MediaAssetEntity::class], version = 1, exportSchema = false)
abstract class PixoraDatabase : RoomDatabase() { abstract fun mediaAssetDao(): MediaAssetDao }
