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

// async request to the backend and fetch the data
async function getRandomMottoUsingAsyncAwait() {
  const response = await fetch('/random_motto');
  const quote = await response.text();
  document.getElementById('motto-container').innerText = quote;
}

// make a request to backend and get my info back
$(document).ready(function () {  
    fetch('/info').then(response => response.json()).then((person) => {
    $("#phone_number").append(person.phone_number);
    $("#email").append(person.email);
    $("#address").append(person.address);
    $("#birthday").append(person.birthday);          
    });
});

function loadComments() {
  fetch('/comments').then(response => response.json()).then((commentLists) => {   
    var cList="";
    //console.log(commentLists);
    // create div according to the length of comments lisk
    commentLists.forEach((comment) => {
       var date = new Date(comment.timestamp);
       cList+="                <div class=\"col-sm-5\">\n" +
                "                    <div class=\"panel panel-default\">\n" +
                "                        <div class=\"panel-heading\">\n" +
                "                            <strong>"+comment.firstName+" "+comment.lastName+"</strong> <span class=\"text-muted\">commented by "+date.getFullYear()+"-"+(date.getMonth()+1)+"-"+ date.getDate()+" "+ date.getHours()+":"+ date.getMinutes() +"</span>" +
                "                        </div>\n" +
                "                        <div class=\"panel-body\">\n" +
                                            comment.comment+"\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "                </div>";
    })

    $("#cList").html(cList);

  });
}



