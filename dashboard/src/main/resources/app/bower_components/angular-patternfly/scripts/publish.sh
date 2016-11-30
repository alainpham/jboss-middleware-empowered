#/bin/sh

set -o errexit -o nounset

if [ -z "$TRAVIS_TAG" -a "$TRAVIS_BRANCH" != "master" ]
then
  echo "This commit was made against $TRAVIS_BRANCH and not the master or tag! Do not deploy!"
  exit 0
fi

# User info
git config user.name "Admin"
git config user.email "angular-patternfly@redhat.com"
git config --global push.default simple

# Add upstream authentication token
git remote add upstream https://$AUTH_TOKEN@github.com/patternfly/angular-patternfly.git

# Commit generated files
git add dist --force
git commit -m "Added files generated by Travis build"

# Push to releases branch
if [ -z "$TRAVIS_TAG" ]
then
  git push upstream master:releases --force -v
fi

exit $?
