//package edu.vassar.cmpu203.plannerapp.view;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import edu.vassar.cmpu203.plannerapp.R;
//import edu.vassar.cmpu203.plannerapp.model.Course;
//import edu.vassar.cmpu203.plannerapp.model.Pair;
//
//// Create the basic adapter extending from RecyclerView.Adapter
//// Note that we specify the custom ViewHolder which gives us access to our views
//public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder> {
//
//    private List<Course> mCourses;
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//
//        // Inflate the custom layout
//        View contactView = inflater.inflate(R.layout.individual_course, parent, false);
//
//        // Return a new holder instance
//        ViewHolder viewHolder = new ViewHolder(contactView);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//
//        Course course = mCourses.get(position);
//        if (course.room.length() < 1) {
//            holder.courseRoom.setText("No room given");
//        }
//        else{
//            holder.courseRoom.setText(course.room);
//        }
//
//        if(course.notes.length() < 1){
//            holder.courseNotes.setText("No additional notes given :)");
//        }
//        else{
//            holder.courseNotes.setText(course.notes);
//        }
//        holder.courseSemester.setText(course.semester.toString());
//        holder.courseName.setText(course.name);
//        holder.courseCode.setText(course.code);
//
//        String res = "";
//        for(int i = 0; i < course.meetingTimes.size(); i++){
//            res += course.meetingTimes.get(i).getLeft().getDayOfWeek() + ". ";
//        }
//        holder.meetingDays.setText(res);
//
//        String res2 = "";
//        Pair<LocalDateTime, LocalDateTime> dateTime = course.meetingTimes.get(0);
//        res2 += String.valueOf(dateTime.getLeft().getHour()) + ":";
//        if(dateTime.getLeft().getMinute() < 10){
//            res2 += "0" + dateTime.getLeft().getMinute() + " - ";
//        }
//        else{
//            res2 += String.valueOf(dateTime.getLeft().getMinute()) + " - ";
//        }
//        res2 += String.valueOf(dateTime.getRight().getHour()) + ":";
//        if(dateTime.getRight().getMinute() < 10){
//            res2 += "0" + dateTime.getRight().getMinute();
//        }
//        else{
//            res2 += String.valueOf(dateTime.getRight().getMinute());
//        }
//        holder.meetingTime.setText(res2);
//    }
//
//    @Override
//    public int getItemCount() {
//        return mCourses.size();
//    }
//    public CoursesAdapter(List<Course> courses) {
//        mCourses = courses;
//    }
//
//    // Provide a direct reference to each of the views within a data item
//    // Used to cache the views within the item layout for fast access
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        // Your holder should contain a member variable
//        // for any view that will be set as you render a row
//        public TextView courseName;
//        public TextView courseCode;
//        public TextView courseNotes;
//        public TextView meetingTime;
//        public TextView meetingDays;
//        public TextView courseRoom;
//        public TextView courseSemester;
//        // We also create a constructor that accepts the entire item row
//        // and does the view lookups to find each subview
//        public ViewHolder(View itemView) {
//            // Stores the itemView in a public final member variable that can be used
//            // to access the context from any ViewHolder instance.
//            super(itemView);
//
//            courseName = (TextView) itemView.findViewById(R.id.courseName);
//            courseCode = (TextView) itemView.findViewById(R.id.courseCode);
//            courseNotes = (TextView) itemView.findViewById(R.id.courseNotes);
//            meetingTime = (TextView) itemView.findViewById(R.id.meetingTime);
//            meetingDays = (TextView) itemView.findViewById(R.id.meetingDays);
//            courseRoom = (TextView) itemView.findViewById(R.id.courseRoom);
//            courseSemester = (TextView) itemView.findViewById(R.id.courseSemester);
//        }
//    }
//}