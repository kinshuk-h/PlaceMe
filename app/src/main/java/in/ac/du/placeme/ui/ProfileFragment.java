package in.ac.du.placeme.ui;

import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import in.ac.du.placeme.R;
import in.ac.du.placeme.adapters.ProfileAdapter;

public class ProfileFragment extends Fragment {
    @Override  public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstance) {
        return inflater.inflate(R.layout.fragment_profile, parent, false);
    }

    @Override public void onActivityCreated(Bundle saved) {
        super.onActivityCreated(saved);
        View root = getView();
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if(activity != null && root != null) {
            try {
                JSONObject object = new JSONObject("{'name': 'RAM KUMAR', 'email': 'shri.babuji@shriresume.com', 'mobile_number': '0000000000', 'skills':"
                        +" ['Sales', 'English', 'Engineering', 'Word', 'Excel', 'Administration', 'Marketing'], 'college_name': None, "
                        +"'degree': ['Bachelor, Technology \\nDeccan College of Engineering & Technology'], 'designation': ['Sales Assistant', 'Sales Manager', 'Team Leader', 'Marketing and Sales Professional'], "
                        +"'experience': ['•', '•', 'April 2014 – Current', 'Sales Manager', 'Solvent Solutions Pvt Ltd', 'Kolkata, West Bangal', 'October 2011 – March 2014', 'Team Leader', 'Serena Global Pvt Ltd', 'Gurgaon, Delhi-NCR', 'August 2009 – October 2011', 'Sales Assistant', 'Tamcoj Technologies', 'Pimpri-Pune, Maharashtra', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum', 'sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies Lorem', 'ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis', 'natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '•', '•', '•', '•', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit lorem ipsum dolor sit.', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit lorem ipsum dolor sit.', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit lorem ipsum dolor sit.', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit lorem ipsum dolor sit.', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum', 'sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies Lorem', 'ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis', 'natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '•', '•', '•', '•', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit lorem ipsum dolor sit.', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit lorem ipsum dolor sit.', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit lorem ipsum dolor sit.', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit lorem ipsum dolor sit.', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum', 'sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies Lorem', 'ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis', 'natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '•', '•', '•', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit lorem ipsum dolor sit.', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit lorem ipsum dolor sit.', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit lorem ipsum dolor sit.', 'Computer Proficiency', 'Languages', '•  Word 2010', '•  Excel 2010', '•  Power Point 2010', '•  Hindi', '•  English', 'Lorem ipsum dolor sit amet', 'Lorem ipsum dolor', 'Lorem ipsum dolor sit'], 'company_names': ['Serena Global Pvt Ltd', 'Solvent Solutions Pvt Ltd', 'Pimpri', 'Tamcoj Technologies'], 'no_of_pages': 3, 'total_experience': 4.58}");
                ProfileAdapter adapter = new ProfileAdapter(activity);
                adapter.add(new Pair<String, String>("Name", object.getString("name")));
                adapter.add(new Pair<String, String>("Email Address", object.getString("email")));
                adapter.add(new Pair<String, String>("Phone Number", object.getString("mobile_number")));
                adapter.add(new Pair<String, String>("Skills", object.getJSONArray("skills").toString()));
                adapter.add(new Pair<String, String>("Degree", object.getJSONArray("degree").toString()));
                adapter.add(new Pair<String, String>("Designation", object.getJSONArray("designation").toString()));
                adapter.add(new Pair<String, String>("Experience", object.getJSONArray("experience").toString()));
                RecyclerView recyclerView = root.findViewById(R.id.recycler_view);
                recyclerView.setAdapter(adapter);
            } catch (JSONException e) { e.printStackTrace(); }
        }

    }
}
