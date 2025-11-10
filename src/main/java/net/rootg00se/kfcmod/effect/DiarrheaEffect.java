package net.rootg00se.kfcmod.effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.Map;
import java.util.WeakHashMap;

public class DiarrheaEffect extends MobEffect {
    private final Map<LivingEntity, Long> lastEffectTime = new WeakHashMap<>();

    public DiarrheaEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(LivingEntity livingEntity, int amplifier) {
        Level level = livingEntity.level();
        long currentTime = level.getGameTime();
        Long lastTime = lastEffectTime.get(livingEntity);

        // Применяем эффекты каждые 10 тиков (0.5 секунды) для оптимизации
        if (lastTime == null || currentTime - lastTime >= 10) {
            applyDisorientationEffects(livingEntity, amplifier);
            lastEffectTime.put(livingEntity, currentTime);
        }

        // Постоянные эффекты
        if (!livingEntity.hasEffect(MobEffects.HUNGER)) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 200, amplifier));
        }
        if (!livingEntity.hasEffect(MobEffects.BLINDNESS)) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 200, amplifier));
        }

        if (!livingEntity.hasEffect(MobEffects.WITHER)) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, amplifier));
        }

        super.applyEffectTick(livingEntity, amplifier);

        if (level.isClientSide && level.random.nextFloat() < 0.3f) {
            for (int i = 0; i < 3; i++) {
                double x = livingEntity.getX() + (level.random.nextDouble() - 0.5) * 2;
                double y = livingEntity.getY() + level.random.nextDouble() * 2;
                double z = livingEntity.getZ() + (level.random.nextDouble() - 0.5) * 2;

                level.addParticle(ParticleTypes.SNEEZE,
                        x, y, z, 0, 0, 0);
            }
        }

        return super.applyEffectTick(livingEntity, amplifier);
    }

    private void applyDisorientationEffects(LivingEntity livingEntity, int amplifier) {
        // Усиленная тошнота
        livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100, amplifier + 1));

        if (livingEntity instanceof Player player) {
            // Случайный поворот камеры
            float yawChange = (livingEntity.level().random.nextFloat() - 0.5f) * 45f;
            float pitchChange = (livingEntity.level().random.nextFloat() - 0.5f) * 30f;

            player.setYRot(player.getYRot() + yawChange);
            player.setXRot(player.getXRot() + pitchChange);

            // Ограничиваем угол наклона
            player.setXRot(Math.min(90, Math.max(-90, player.getXRot())));

            // Случайное движение
            if (livingEntity.level().random.nextFloat() < 0.3f) {
                double motionX = (livingEntity.level().random.nextDouble() - 0.5) * 0.1;
                double motionZ = (livingEntity.level().random.nextDouble() - 0.5) * 0.1;
                livingEntity.setDeltaMovement(
                        livingEntity.getDeltaMovement().x + motionX,
                        livingEntity.getDeltaMovement().y,
                        livingEntity.getDeltaMovement().z + motionZ
                );
            }

            // Случайные звуки для усиления дезориентации
            if (livingEntity.level().random.nextFloat() < 0.1f && !livingEntity.level().isClientSide) {
                livingEntity.level().playSound(null, livingEntity.getX(), livingEntity.getY(), livingEntity.getZ(),
                        SoundEvents.AMBIENT_CAVE.get(), SoundSource.AMBIENT, 0.8F,
                        0.5F + livingEntity.level().random.nextFloat() * 1.5F);
            }
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }

    @Override
    public void onEffectAdded(LivingEntity pLivingEntity, int pAmplifier) {
        Level level = pLivingEntity.level();
        if (!level.isClientSide()) {
            level.playSound(null, pLivingEntity.getX(), pLivingEntity.getY(), pLivingEntity.getZ(),
                    SoundEvents.GHAST_SCREAM, SoundSource.PLAYERS, 0.5F,
                    0.8F + level.random.nextFloat() * 0.4F);
        }
        super.onEffectAdded(pLivingEntity, pAmplifier);
    }

    //    @Override
//    public void (LivingEntity livingEntity, int amplifier) {
//        // Очистка при окончании эффекта
//        lastEffectTime.remove(livingEntity);
//        super.onEffectRemoved(livingEntity, amplifier);
//    }
}
