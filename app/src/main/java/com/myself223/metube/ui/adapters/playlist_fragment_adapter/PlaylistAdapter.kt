package com.myself223.metube.ui.adapters.playlist_fragment_adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.myself223.metube.data.models.BaseMainResponse
import com.myself223.metube.data.models.ItemPlaylistDto
import com.myself223.metube.databinding.ItemPlaylistBinding
import com.myself223.metube.ui.fragments.playlist.PlaylistsFragment

class PlaylistAdapter(playlistsFragment: PlaylistsFragment, private val click: Click) : ListAdapter<BaseMainResponse<ItemPlaylistDto>, PlaylistAdapter.PlaylistViewHolder>(
    PlaylistDiffUtill()
) {
    class PlaylistViewHolder(private val binding: ItemPlaylistBinding) : ViewHolder(binding.root) {
        fun onBind(it: BaseMainResponse<ItemPlaylistDto>) {

            binding.itemNamePlaylist.text = it.items.get(1).snippetDto?.title
            binding.itemNamePlaylist.text = it.items.get(1).contentDetails?.itemCount?.toString()
            Glide.with(binding.root).load(it.items.get(1).snippetDto?.descriptions?.mediumDto?.url).centerCrop().into(binding.itemPlaylistPreview)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistViewHolder {
        return PlaylistViewHolder(ItemPlaylistBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PlaylistViewHolder, position: Int) {
        val PlaylistModel = getItem(position)
        holder.itemView.setOnClickListener {
            click.onClick(PlaylistModel)
        }
        holder.onBind(PlaylistModel)
    }

    class PlaylistDiffUtill : DiffUtil.ItemCallback<BaseMainResponse<ItemPlaylistDto>>() {
        override fun areItemsTheSame(
            oldItem: BaseMainResponse<ItemPlaylistDto>,
            newItem: BaseMainResponse<ItemPlaylistDto>
        ): Boolean {
           return oldItem == newItem

        }

        override fun areContentsTheSame(
            oldItem: BaseMainResponse<ItemPlaylistDto>,
            newItem: BaseMainResponse<ItemPlaylistDto>
        ): Boolean {
            return oldItem == newItem
        }
    }

    interface Click {
        fun onClick(model: BaseMainResponse<ItemPlaylistDto>)
    }
}
