// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomInfo() {
  const random_infos =
      ['Computer Science Major', 'BMCC', 'University at Buffalo', 'Chinese'];

  // Pick a random greeting.
  const  random_info= random_infos[Math.floor(Math.random() * random_infos.length)];

  // Add it to the page.
  const infoContainer = document.getElementById('info-container');
  infoContainer.innerText = random_info;
}