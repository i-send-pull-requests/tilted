

package org.agmas.client.mixin;

import net.fabricmc.loader.impl.util.log.Log;
import net.fabricmc.loader.impl.util.log.LogCategory;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
//? if >= 1.21.11 {
import net.minecraft.client.renderer.entity.state.AvatarRenderState;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.util.EasingType;
import net.minecraft.world.entity.Avatar;
//? } else {
/*import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.model.HumanoidModel;
*///? }
import net.minecraft.util.Mth;
import org.agmas.ModAttachments;
import org.agmas.client.TiltedClient;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = HumanoidModel.class)
public abstract class LeanHeadMixin {
	@Shadow
	@Final
	public ModelPart head;

	//? if >=1.21.11 {
	@Inject(method = "setupAnim(Lnet/minecraft/client/renderer/entity/state/HumanoidRenderState;)V",at = @At("TAIL"))
	public void leanHead(HumanoidRenderState state, CallbackInfo ci) {
		if (state instanceof AvatarRenderState) {
		//? } else {
		
	/*@Inject(method = "setupAnim(Lnet/minecraft/client/renderer/entity/state/HumanoidRenderState;)V",at = @At("TAIL"))
	public void leanHead(HumanoidRenderState state, CallbackInfo ci) {
		if (state instanceof HumanoidRenderState) {
		*///? }
			var lean = state.getData(TiltedClient.leaningStateDataKey);
			if (lean != null) {
				lean = lean.intValue();
				if (lean != 0) {
					float delta = Mth.clamp((state.ageInTicks - state.getData(TiltedClient.leaningAgeStateDataKey).floatValue()) / 2.0f, 0f, 1f);

					//? if >= 1.21.11 {
					float progress = EasingType.OUT_SINE.apply(delta);
					//? } else {
					/*float progress = Mth.easeInOutSine(delta);
					 *///? }
					head.x += Mth.lerp(progress, 0, lean * 2.5f);
					head.zRot += Mth.lerp(progress, 0, lean * 0.25f);
				}
			}
		}
	}
}