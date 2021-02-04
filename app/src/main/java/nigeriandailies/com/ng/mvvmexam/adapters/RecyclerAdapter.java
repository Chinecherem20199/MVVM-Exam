package nigeriandailies.com.ng.mvvmexam.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import nigeriandailies.com.ng.mvvmexam.R;
import nigeriandailies.com.ng.mvvmexam.model.NicePlace;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;
    private List<NicePlace> mNicePlaces = new ArrayList<>();


    public RecyclerAdapter( Context context, List<NicePlace> nicePlaces){
        mNicePlaces = nicePlaces;
        mContext = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
// Set the name of the 'NicePlace'
        ((ViewHolder)holder).mName.setText(mNicePlaces.get(position).getTitle());

        // Set the image
        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(mNicePlaces.get(position).getImageUrl())
                .into(((ViewHolder)holder).mImage);
    }


    @Override
    public int getItemCount() {
        return mNicePlaces.size();
    }
    private class ViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView mImage;
        private TextView mName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.image);
            mName = itemView.findViewById(R.id.image_name);
        }
    }
}
