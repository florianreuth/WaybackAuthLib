# WaybackAuthLib

Addon for Mojang's AuthLib to support Yggdrasil authentication again

## Motivation

With the release of AuthLib 5.0, Mojang has removed all API methods to log in via the Yggdrasil Authentication system,
as Yggdrasil has been officially terminated. However, many third-party log in methods use the Yggdrasil interface as a
reference, this library is an addon for the AuthLib which adds all old methods back using the internals of the AuthLib
to be as compact as possible. This library will probably also be used in the future to restore even more methods that
have been removed from the AuthLib.

## Use in Gradle

If you want to depend on WaybackAuthLib in your own project, use the Maven repository here:

https://mvnrepository.com/artifact/de.florianreuth/waybackauthlib

or

https://maven.florianreuth.de/#/snapshots/de/florianreuth/waybackauthlib (for snapshots)

The repository page includes the latest coordinates and setup instructions.

Jar builds can be downloaded from my build server: https://build.florianreuth.de/job/WaybackAuthLib/

## Requirements

- [AuthLib](https://mvnrepository.com/artifact/com.mojang/authlib)
- Java **17**.

## Example usage

### Login with username and password / access token, log out and verify session

```java
final WaybackAuthLib authenticator = new WaybackAuthLib("<your auth host server>", clientToken, Proxy.NO_PROXY);

authenticator.setUsername(username);
authenticator.setPassword(password);

// You can also use authenticator.setAcessToken(), the logIn method will then refresh the acess token
// if it is expired (once you logged in using username/password, the access token field will also be updated automatically)
authenticator.logIn();

if (authenticator.isLoggedIn()) {
    final GameProfile profile = authenticator.getCurrentProfile();
    // Do something with the profile
}

final boolean isTokenValid = authenticator.checkTokenValidity();
if (isTokenValid) {
    // Do something
}

authenticator.logOut(); // This will invalidate the access token and reset all storages
```

## Contact

- Issues: https://github.com/florianreuth/WaybackAuthLib/issues
- Discord: https://florianreuth.de/discord
