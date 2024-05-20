package com.myself223.metube.ui.adapters.playlist_fragment_adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.myself223.metube.data.models.ItemPlaylistDto
import com.myself223.metube.databinding.ItemPlaylistBinding
import com.myself223.metube.ui.utils.loadImageURL

open class PlaylistAdapter(val context: Context, private val click:(id:String)->Unit) : ListAdapter<ItemPlaylistDto, PlaylistAdapter.PlaylistViewHolder>(
    PlaylistDiffUtill()
) {
    class PlaylistViewHolder(private val binding: ItemPlaylistBinding) : ViewHolder(binding.root) {
        fun onBind(it:ItemPlaylistDto) {

            binding.itemTvTitle.text = it.snippetDto?.title
            binding.itemImg.loadImageURL(it.snippetDto?.thumbnails?.default?.url)
            binding.itemTvCount.text = it.contentDetails?.itemCount?.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val playlistModel = getItem(position)
        holder.itemView.setOnClickListener {
            playlistModel.id?.let { it1 -> click(it1) }
        }
        holder.onBind(playlistModel)
    }

    class PlaylistDiffUtill : DiffUtil.ItemCallback<ItemPlaylistDto>() {


        override fun areItemsTheSame(oldItem: ItemPlaylistDto, newItem: ItemPlaylistDto): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ItemPlaylistDto,
            newItem: ItemPlaylistDto
        ): Boolean {

            return oldItem == newItem
        }
    }
}
