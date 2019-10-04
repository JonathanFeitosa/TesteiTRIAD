package br.org.itriad.testeitriad;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

public class ListRepositoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.host_listrepository);

        // Toolbar fragments integrate
            NavigationUI.setupActionBarWithNavController(
                this,
                Navigation.findNavController(this, R.id.navHostFragment)
            );
    }

   // Button Back toolbar
    @Override
     public boolean onSupportNavigateUp() {
        return Navigation.findNavController(this, R.id.navHostFragment).navigateUp();
    }
}
