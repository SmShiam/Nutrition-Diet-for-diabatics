package com.example.szs;

import android.app.Application;
import android.os.AsyncTask;

import com.example.szs.activity.Activity;
import com.example.szs.activity.ActivityDao;
import com.example.szs.bp.Bp;
import com.example.szs.bp.BpDao;
import com.example.szs.gulcose.Glucose;
import com.example.szs.gulcose.GlucoseDao;
import com.example.szs.meals.Meals;
import com.example.szs.meals.MealsDao;
import com.example.szs.medicine.Medicine;
import com.example.szs.medicine.MedicineDao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class Nutrition_Repository {

    List<Activity> myActivityList = new ArrayList<>();
    List<Bp> myBpList = new ArrayList<>();
    List<Medicine> myMedicineList = new ArrayList<>();
    List<Meals> myMealsList = new ArrayList<>();
    List<Glucose> myGlucoseList = new ArrayList<>();


    private ActivityDao activityDao;
    private BpDao bpDao;
    private MedicineDao medicineDao;
    private MealsDao mealsDao;
    private GlucoseDao glucoseDao;

    public Nutrition_Repository(Application application) {
        Nutrition_Database db = Nutrition_Database.getDatabase(application);
        activityDao = db.getActivityDao();
        bpDao = db.getBpDao();
        medicineDao = db.getMedicineDao();
        mealsDao = db.getMealsDao();
        glucoseDao = db.GetGlucoseDao();


    }


    public void InsertActivity(Activity activity) {
        new InsertTask(activityDao).execute(activity);

    }

    public List<Activity> GetAllActivity() {
        try {
            myActivityList = new GetAllActivityTask(activityDao).execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return myActivityList;

    }

    public void DeleteActivity(Activity activity) {
        new deleteActivityTask(activityDao).execute(activity);
    }


    public void InsertBp(Bp bp) {
        new InsertBpTask(bpDao).execute(bp);

    }

    public List<Bp> GetAllBp() {
        try {
            myBpList = new GetAllBpTask(bpDao).execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return myBpList;

    }

    public void DeleteBp(Bp bp) {
        new deleteBpTask(bpDao).execute(bp);
    }


    public void InsertMedicine(Medicine medicine) {
        new InsertMedicineTask(medicineDao).execute(medicine);

    }

    public List<Medicine> GetAllMedicine() {
        try {
            myMedicineList = new GetAllMedicineTask(medicineDao).execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return myMedicineList;

    }

    public void DeleteMedicine(Medicine medicine) {
        new deleteMedicineTask(medicineDao).execute(medicine);
    }

    public void InsertMeals(Meals meals) {
        new InsertMealsTask(mealsDao).execute(meals);

    }

    public List<Meals> GetAllMeals() {
        try {
            myMealsList = new GetAllMealsTask(mealsDao).execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return myMealsList;

    }

    public void DeleteMeals(Meals meals) {
        new deleteMealsTask(mealsDao).execute(meals);
    }


    public void InsertGlucose(Glucose glucose) {
        new InsertGlucoseTask(glucoseDao).execute(glucose);

    }

    public List<Glucose> GetAllGlucose() {
        try {
            myGlucoseList = new GetAllGlucoseTask(glucoseDao).execute().get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return myGlucoseList;

    }

    public void DeleteGlucose(Glucose glucose) {
        new deleteGlucoseTask(glucoseDao).execute(glucose);
    }

    //background
    private static class InsertTask extends AsyncTask<Activity, Void, Void> {
        private ActivityDao dao;

        InsertTask(ActivityDao activityDao) {
            dao = activityDao;
        }

        @Override
        protected Void doInBackground(Activity... activities) {
            dao.insert(activities[0]);
            return null;
        }
    }


    private static class GetAllActivityTask extends AsyncTask<Void, Void, List<Activity>> {
        ActivityDao dao;

        GetAllActivityTask(ActivityDao activityDao) {
            dao = activityDao;
        }

        @Override
        protected List<Activity> doInBackground(Void... voids) {
            return dao.GetAllActivity();
        }
    }


    private static class deleteActivityTask extends AsyncTask<Activity, Void, Void> {
        ActivityDao dao;

        deleteActivityTask(ActivityDao activityDao) {
            dao = activityDao;
        }

        @Override
        protected Void doInBackground(Activity... activities) {
            dao.delete(activities[0]);
            return null;
        }
    }

    //bp background
    private static class InsertBpTask extends AsyncTask<Bp, Void, Void> {
        private BpDao dao;

        InsertBpTask(BpDao bpDao) {
            dao = bpDao;
        }

        @Override
        protected Void doInBackground(Bp... bps) {
            dao.insert(bps[0]);
            return null;
        }
    }


    private static class GetAllBpTask extends AsyncTask<Void, Void, List<Bp>> {
        BpDao dao;

        GetAllBpTask(BpDao bpDao) {
            dao = bpDao;
        }

        @Override
        protected List<Bp> doInBackground(Void... voids) {
            return dao.GetAllBp();
        }
    }


    private static class deleteBpTask extends AsyncTask<Bp, Void, Void> {
        BpDao dao;

        deleteBpTask(BpDao bpDao) {
            dao = bpDao;
        }


        @Override
        protected Void doInBackground(Bp... bps) {
            dao.delete(bps[0]);
            return null;
        }
    }


    //Medicine background
    private static class InsertMedicineTask extends AsyncTask<Medicine, Void, Void> {
        private MedicineDao dao;

        InsertMedicineTask(MedicineDao medicineDao) {
            dao = medicineDao;
        }

        @Override
        protected Void doInBackground(Medicine... medicines) {
            dao.insert(medicines[0]);
            return null;
        }
    }


    private static class GetAllMedicineTask extends AsyncTask<Void, Void, List<Medicine>> {
        MedicineDao dao;

        GetAllMedicineTask(MedicineDao medicineDao) {
            dao = medicineDao;
        }

        @Override
        protected List<Medicine> doInBackground(Void... voids) {
            return dao.GetAllMedicine();
        }
    }


    private static class deleteMedicineTask extends AsyncTask<Medicine, Void, Void> {
        MedicineDao dao;

        deleteMedicineTask(MedicineDao medicineDao) {
            dao = medicineDao;
        }


        @Override
        protected Void doInBackground(Medicine... medicines) {
            dao.delete(medicines[0]);
            return null;
        }
    }

    //Meals background
    private static class InsertMealsTask extends AsyncTask<Meals, Void, Void> {
        private MealsDao dao;

        InsertMealsTask(MealsDao mealsDao) {
            dao = mealsDao;
        }

        @Override
        protected Void doInBackground(Meals... meals) {
            dao.insert(meals[0]);
            return null;
        }
    }


    private static class GetAllMealsTask extends AsyncTask<Void, Void, List<Meals>> {
        MealsDao dao;

        GetAllMealsTask(MealsDao mealsDao) {
            dao = mealsDao;
        }

        @Override
        protected List<Meals> doInBackground(Void... voids) {
            return dao.GetAllMeals();
        }
    }


    private static class deleteMealsTask extends AsyncTask<Meals, Void, Void> {
        MealsDao dao;

        deleteMealsTask(MealsDao mealsDao) {
            dao = mealsDao;
        }

        @Override
        protected Void doInBackground(Meals... meals) {
            dao.delete(meals[0]);
            return null;
        }
    }

    private static class InsertGlucoseTask extends AsyncTask<Glucose, Void, Void> {
        private GlucoseDao dao;

        InsertGlucoseTask(GlucoseDao glucoseDao) {
            dao = glucoseDao;
        }


        @Override
        protected Void doInBackground(Glucose... glucoses) {
            dao.insert(glucoses[0]);
            return null;
        }
    }


    private static class GetAllGlucoseTask extends AsyncTask<Void, Void, List<Glucose>> {
        GlucoseDao dao;

        GetAllGlucoseTask(GlucoseDao glucoseDao) {
            dao = glucoseDao;
        }

        @Override
        protected List<Glucose> doInBackground(Void... voids) {
            return dao.GetAllGlucose();
        }
    }


    private static class deleteGlucoseTask extends AsyncTask<Glucose, Void, Void> {
        GlucoseDao dao;

        deleteGlucoseTask(GlucoseDao glucoseDao) {
            dao = glucoseDao;
        }


        @Override
        protected Void doInBackground(Glucose... glucoses) {
            dao.delete(glucoses[0]);
            return null;
        }
    }


}
