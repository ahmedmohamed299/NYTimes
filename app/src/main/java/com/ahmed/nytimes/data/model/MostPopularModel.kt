package com.ahmed.nytimes.data.model
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
data class MostPopularModel(
    var `abstract`: String,
    var adx_keywords: String,
    var asset_id: Long,
    var byline: String,
    var des_facet: List<String>,
    var eta_id: Int,
    var geo_facet: List<String>,
    var id: Long,
    var nytdsection: String,
    var org_facet: List<String>,
    var per_facet: List<String>,
    var published_date: String,
    var section: String,
    var source: String,
    var subsection: String,
    var title: String,
    var type: String,

    var media: @RawValue List<Media>,
    var updated: String,
    var uri: String,
    var url: String
): Parcelable {
    data class Media(
        var approved_for_syndication: Int,
        var caption: String,
        var copyright: String,
        @SerializedName("media-metadata")
        var mediaMetadata: List<MediaMetadata>,
        var subtype: String,
        var type: String
    ) {
        data class MediaMetadata(
            var format: String,
            var height: Int,
            var url: String,
            var width: Int
        )
    }
}