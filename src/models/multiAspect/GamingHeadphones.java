package models.multiAspect;

import java.util.Collections;
import java.util.Set;

public class GamingHeadphones extends Headphones {

    private Set<String> compatiblePlatforms;

    public GamingHeadphones(ConnectionMethod connectionMethod, String manufacturer, String modelName, int cableLength, String connectorType, int bluetoothRange,
                            Set<String> compatiblePlatforms) {
        super(connectionMethod, manufacturer, modelName, cableLength, connectorType, bluetoothRange);

        setCompatiblePlatforms(compatiblePlatforms);
    }

    public Set<String> getCompatiblePlatforms() {
        return Collections.unmodifiableSet(compatiblePlatforms);
    }

    private void setCompatiblePlatforms(Set<String> compatiblePlatforms) {
        if(compatiblePlatforms == null) throw new IllegalArgumentException("A list of compatible platforms is required");
        if(compatiblePlatforms.size() < 1) throw new IllegalStateException("At least one compatible platform has to be listed");

        this.compatiblePlatforms = compatiblePlatforms;
    }

    public void addCompatiblePlatform(String compatiblePlatform) {
        if(compatiblePlatform == null || compatiblePlatform.isBlank()) throw new IllegalArgumentException("Enter a non-empty name of a platform");
        if(compatiblePlatforms.contains(compatiblePlatform)) throw new IllegalArgumentException("This platform is already in the set");

        compatiblePlatforms.add(compatiblePlatform);
    }

    public void removeCompatiblePlatform(String compatiblePlatform) {
        if(compatiblePlatform == null || compatiblePlatform.isBlank()) throw new IllegalArgumentException("Enter a non-empty name of a platform");
        if(!compatiblePlatforms.contains(compatiblePlatform))
            throw new IllegalArgumentException("Selected platform isn't listed in the compatibility list of these headphones");
        if(compatiblePlatforms.size() == 1) throw new IllegalStateException("Cannot remove the last platform from the compatibility list");

        compatiblePlatforms.remove(compatiblePlatform);
    }
}
