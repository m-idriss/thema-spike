import {ChangeDetectionStrategy, Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {catchError, tap} from 'rxjs/operators';
import {environment} from "../environments/environment";
import {Word} from "./models/Word";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  changeDetection: ChangeDetectionStrategy.Default,
})
export class AppComponent {
  title = 'Shiba Inu';
  subtitle = 'Dog Breed';
  submit_label = 'submit';
  avatar_url = "https://material.angular.io/assets/img/examples/shiba1.jpg";
  word: string = '';
  synonyms: string[] = [];
  example: string = '';
  error: string = '';


  constructor(private http: HttpClient) {
  }


  onFormSubmit() {
    this.error = '';
    // Fetch synonyms using your service, e.g. via HTTP request
    this.http.get<Word>(environment.apiUrl + '/rest/synonyms/' + this.word)
      .pipe(
        tap((data) => {
          if (data == null) {
            this.error = 'Error fetching synonyms:';
          } else {
            this.synonyms = data.synonyms; // Update the synonyms array with fetched data
            this.example = data.word; // Update the synonyms array with fetched data
          }
        }),
        catchError((error) => {
          console.error('Error fetching synonyms:', error);
          throw error; // Rethrow the error to propagate it to the error handling downstream
        })
      )
      .subscribe();
  }

}
