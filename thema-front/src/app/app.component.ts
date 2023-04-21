import {ChangeDetectionStrategy, Component} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from "../environments/environment";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  changeDetection: ChangeDetectionStrategy.Default,
})
export class AppComponent {
  title = 'thema-front';
  longText = `The Shiba Inu is the smallest of the six original and distinct spitz breeds of dog
  from Japan. A small, agile dog that copes very well with mountainous terrain, the Shiba Inu was
  originally bred for hunting.`;

  word: string = '';
  synonyms: string[] = [];

  constructor(private http: HttpClient) {
  }


  onFormSubmit() {
    // Fetch synonyms using your service, e.g. via HTTP request
    this.http.get<string[]>(environment.apiUrl + '/synonyms/' + this.word)
      .subscribe(
        (data) => {
          this.synonyms = data; // Update the synonyms array with fetched data
        },
        (error) => {
          console.error('Error fetching synonyms:', error);
        }
      );
  }

}
