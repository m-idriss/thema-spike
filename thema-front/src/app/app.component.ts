import {ChangeDetectionStrategy, Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {catchError, tap} from 'rxjs/operators';
import {environment} from "../environments/environment";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  changeDetection: ChangeDetectionStrategy.Default,
})
export class AppComponent {
  title = 'Shiba Inu';
  subtitle = 'Dog Breed';
  title_h2 = 'Synonyms:'
  submit_label = 'submit';
  avatar_url = "https://material.angular.io/assets/img/examples/shiba1.jpg";
  word: string = '';
  synonyms: string[] = [];

  constructor(private http: HttpClient) {
  }


  onFormSubmit() {
    // Fetch synonyms using your service, e.g. via HTTP request
    this.http.get<string[]>(environment.apiUrl + '/synonyms/' + this.word)
      .pipe(
        tap((data) => {
          this.synonyms = data; // Update the synonyms array with fetched data
        }),
        catchError((error) => {
          console.error('Error fetching synonyms:', error);
          throw error; // Rethrow the error to propagate it to the error handling downstream
        })
      )
      .subscribe();
  }

}
