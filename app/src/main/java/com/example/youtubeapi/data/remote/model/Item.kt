package com.example.youtubeapi.data.remote.model

data class Item(
    val contentDetails: ContentDetails,
    val etag: String,
    val id: String,
    val kind: String,
    val snippet: Snippet
)

data class VideoItem(
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val pageInfo: PageInfo
)

data class PlaylistItem(
    val kind: String,
    val items: List<Item>,
)

data class Playlists(
    val etag: String,
    val items: List<Item>,
    val kind: String,
    val nextPageToken: String,
    val pageInfo: PageInfo
)
data class PlaylistInfo(
    val id : String,
    val title : String,
    val desc : String,
    val itemCount : Int
) : java.io.Serializable

data class Snippet(
    val channelId: String,
    val channelTitle: String,
    val description: String,
    val localized: Localized,
    val publishedAt: String,
    val thumbnails: Thumbnails,
    val title: String
)

data class ContentDetails(
    val itemCount: Int
)

data class Localized(
    val description: String,
    val title: String
)

data class PageInfo(
    val resultsPerPage: Int,
    val totalResults: Int
)

data class Thumbnails(
    val default: Default,
    val medium: Medium,
    val high: High,
    val standard: Standard,
    val maxres: Maxres

)

data class Default(
    val height: Int,
    val url: String,
    val width: Int
)

data class Medium(
    val height: Int,
    val url: String,
    val width: Int
)

data class High(
    val height: Int,
    val url: String,
    val width: Int
)

data class Standard(
    val height: Int,
    val url: String,
    val width: Int
)

data class Maxres(
    val height: Int,
    val url: String?,
    val width: Int
)