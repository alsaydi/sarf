# Publish Angular App to Github Pages
To publish this angular app to github pages:
* Make sure you're on the right branch (pages in this case)
* Change to the proper directory (cd sarf-ui)
* Build in prod mode: ng build --configuration production --output-path ../docs --base-href /
* cd ../docs
* git restore CNAME (in my case I have a DNS entry pointing to this github pages app)
* mv index.html 404.html (yes, we don't need index.html)

These steps are needed if you want to test locally
* XXrm -fRr /usr/share/nginx/html/
* cp -vR . /usr/share/nginx/html