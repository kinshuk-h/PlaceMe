package in.ac.du.placeme.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;

import in.ac.du.placeme.R;
import in.ac.du.placeme.adapters.FeedAdapter;
import in.ac.du.placeme.adapters.JobAdapter;

public class JobFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_jobs, parent, false);
    }

    @Override public void onActivityCreated(Bundle saved) {
        super.onActivityCreated(saved);
        View root = getView();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if(activity != null && root != null) {
            RecyclerView recycler = root.findViewById(R.id.recycler_view);
            JobAdapter adapter = new JobAdapter(activity);
            try {
                JSONArray array = new JSONArray("[\n" +
                        "  {\n" +
                        "    \"img\":\"https://thedesignlove.com/wp-content/uploads/2018/02/Case-Study-The-Microsoft-Logo-Evolution-5.jpg\",\n" +
                        "    \"title\":\"Microsoft\",\n" +
                        "    \"location\": \"Delhi\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"img\":\"https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Apple_logo_black.svg/1200px-Apple_logo_black.svg.png\",\n" +
                        "    \"title\":\"Apple\",\n" +
                        "    \"location\": \"California\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"img\":\"https://upload.wikimedia.org/wikipedia/commons/5/51/IBM_logo.svg\",\n" +
                        "    \"title\":\"Microsoft\",\n" +
                        "    \"location\": \"California\"\n" +
                        "  }\n" +
                        "]");
                for(int i=0;i<array.length();i++) {
                    adapter.add(array.getJSONObject(i));
                }
                recycler.setAdapter(adapter);
            }catch (Exception e) { e.printStackTrace(); }
        }
    }
}