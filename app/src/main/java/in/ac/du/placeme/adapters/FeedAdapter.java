package in.ac.du.placeme.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import in.ac.du.placeme.R;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    private AppCompatActivity context;
    private ArrayList<JSONObject> feeds = new ArrayList<>();

    public FeedAdapter(AppCompatActivity context) {
        this.context = context;
    }

    @NonNull @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_feed, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        try {
            final JSONObject obj = feeds.get(position);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        URL url = new URL(obj.getString("img"));
                        final Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                        context.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                holder.base.setImageBitmap(image);
                            }
                        });
                    } catch (Exception e) { e.printStackTrace(); }
                }
            }).start();
            holder.title.setText(obj.getString("title"));
            holder.body.setText(obj.getString("body"));
            holder.creator.setText(obj.getString("creator"));
            holder.location.setText(obj.getString("location"));
        } catch (Exception e) {
            Log.d(FeedAdapter.class.getName(), "error: " + e);
            e.printStackTrace();
        }
    }

    @Override public int getItemCount() { return feeds.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View root; ImageView base; TextView location, title, body, creator;
        public ViewHolder(View root) {
            super(root); this.root = root;
            base = root.findViewById(R.id.feed_img);
            location = root.findViewById(R.id.feed_location);
            title = root.findViewById(R.id.feed_title);
            body = root.findViewById(R.id.feed_body);
            creator = root.findViewById(R.id.feed_creator);
        }
    }

    public void add(JSONObject object) {
        feeds.add(object); notifyItemInserted(feeds.size()-1);
    }
}
