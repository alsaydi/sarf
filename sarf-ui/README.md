# Publish Angular App to Github Pages
To publish this angular app to github pages:
* Make sure you're on the right branch (pages in this case)
* Change to the proper directory (cd sarf-ui)
* Build in prod mode: ng build --configuration production --output-path ../docs --base-href /
* cd ../docs
* git restore CNAME (in my case I have a DNS entry pointing to this github pages app)
* git restore Dockerfile (we should move this file elsewhere)
* cp index.html 404.html (we need both, without index.html Google Bot won't find us and without 404 direct URLs won't work.)
    test with https://sarf.one/verb/tri/u/%D8%BA%D9%84%D9%84/1/gerunds for example

These steps are needed if you want to test locally
* XXrm -fRr /usr/share/nginx/html/
* cp -vR . /usr/share/nginx/html