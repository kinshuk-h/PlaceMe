package in.ac.du.placeme.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;

import in.ac.du.placeme.R;
import in.ac.du.placeme.adapters.FeedAdapter;

public class HomeFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, parent, false);
    }

    @Override public void onActivityCreated(Bundle saved) {
        super.onActivityCreated(saved);
        View root = getView();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if(activity != null && root != null) {
            RecyclerView recycler = root.findViewById(R.id.recycler_view);
            FeedAdapter adapter = new FeedAdapter(activity);
            try {
                JSONArray array = new JSONArray("[\n" +
                        "          {\"id\": 1 , \"creator\": \"John\", \"title\": \"Session on azure\", \"body\": \"Get ready for amazing session on azure\", \"time\":\"21:12:23:123000\", \"location\":\"Delhi\", \"img\":\"https://lh3.googleusercontent.com/proxy/PvOJOpL1_gp3tCbdMDSDp7mYeS_n04XtZRs49j7T0nslUp1ija47LVZpapc2xM48gUURHWy5KOFlAK1Z\"},\n" +
                        "          {\"id\": 2 , \"creator\": \"Micheal\", \"title\": \"Session on ibm\", \"body\": \"Upcoming session on ibm\", \"time\":\"12:12:23:123000\", \"location\":\"Pune\", \"img\":\"https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcReembGKf7p5XTUKvK46st9YsA0ex4VgFfGNCPaP65XtGRVdGE3\"},\n" +
                        "          {\"id\": 1 , \"creator\": \"John\", \"title\": \"Session on azure\", \"body\": \"Get ready for amazing session on azure\", \"time\":\"21:12:23:123000\", \"location\":\"Delhi\", \"img\":\"https://lh3.googleusercontent.com/proxy/PvOJOpL1_gp3tCbdMDSDp7mYeS_n04XtZRs49j7T0nslUp1ija47LVZpapc2xM48gUURHWy5KOFlAK1Z\"}\n" +
                        "\n" +
                        "        ]");
                for(int i=0;i<array.length();i++) {
                    adapter.add(array.getJSONObject(i));
                }
                recycler.setAdapter(adapter);
            }catch (Exception e) { e.printStackTrace(); }
        }
    }

}