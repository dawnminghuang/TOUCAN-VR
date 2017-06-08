package fr.unice.i3s.uca4svr.toucan_vr.tilespicker;

import org.gearvrf.GVRPicker;
import org.gearvrf.GVRSceneObject;
import org.gearvrf.IPickEvents;

public class TilesPicker implements IPickEvents {

  private static TilesPicker tilesPicker = null;
  private boolean[] pickedTiles;

  private TilesPicker() {
  }

  public static TilesPicker getPicker() {
    if (tilesPicker == null) tilesPicker = new TilesPicker();
    return tilesPicker;
  }

  public synchronized boolean isPicked(int index) {

    if (pickedTiles != null && pickedTiles.length > index) {
      return pickedTiles[index];
    } else {
      return true;
    }
  }

  @Override
  public synchronized void onPick(GVRPicker picker) {
    GVRPicker.GVRPickedObject[] pickedObjects = picker.getPicked();
    pickedTiles = new boolean[pickedObjects.length];
    for (int i = 0; i < pickedObjects.length; i++)
      pickedTiles[i] = pickedObjects[i] != null;
  }

  @Override
  public void onNoPick(GVRPicker picker) {

  }

  @Override
  public void onEnter(GVRSceneObject sceneObj, GVRPicker.GVRPickedObject collision) {

  }

  @Override
  public void onExit(GVRSceneObject sceneObj) {

  }

  @Override
  public void onInside(GVRSceneObject sceneObj, GVRPicker.GVRPickedObject collision) {

  }
}
