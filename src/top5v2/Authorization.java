package top5v2;

import org.scribe.builder.api.DefaultApi10a;
import org.scribe.model.Token;

public class Authorization extends DefaultApi10a {

  @Override
  public String getAccessTokenEndpoint() {
    return null;
  }

  @Override
  public String getAuthorizationUrl(Token arg0) {
    return null;
  }

  @Override
  public String getRequestTokenEndpoint() {
    return null;
  }
}

