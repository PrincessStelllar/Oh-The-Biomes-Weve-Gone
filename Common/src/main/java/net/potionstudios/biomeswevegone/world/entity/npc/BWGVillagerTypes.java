package net.potionstudios.biomeswevegone.world.entity.npc;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;
import net.potionstudios.biomeswevegone.BiomesWeveGone;
import net.potionstudios.biomeswevegone.PlatformHandler;
import net.potionstudios.biomeswevegone.world.level.levelgen.biome.BWGBiomes;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * Villager types for Oh The Biomes We've Gone
 * @see VillagerType
 * @author Joseph T. McQuigg
 */
public class BWGVillagerTypes {

	public static final ResourceKey<VillagerType> RED_ROCK = createKey("red_rock");
	public static final ResourceKey<VillagerType> SALEM = createKey("salem");
	public static final ResourceKey<VillagerType> SKYRIS = createKey("skyris");

	public static void setVillagerBiomes(BiConsumer<ResourceKey<Biome>, ResourceKey<VillagerType>> consumer) {
		consumer.accept(BWGBiomes.MOJAVE_DESERT, VillagerType.DESERT);
		consumer.accept(BWGBiomes.WINDSWEPT_DESERT, VillagerType.DESERT);
		consumer.accept(BWGBiomes.TROPICAL_RAINFOREST, VillagerType.JUNGLE);
		consumer.accept(BWGBiomes.WHITE_MANGROVE_MARSHES, VillagerType.SWAMP);
		consumer.accept(BWGBiomes.BAYOU, VillagerType.SWAMP);
		consumer.accept(BWGBiomes.CYPRESS_SWAMPLANDS, VillagerType.SWAMP);
		consumer.accept(BWGBiomes.CYPRESS_WETLANDS, VillagerType.SWAMP);
		consumer.accept(BWGBiomes.BAYOU, VillagerType.SWAMP);
		consumer.accept(BWGBiomes.PALE_BOG, VillagerType.SWAMP);
		consumer.accept(BWGBiomes.RED_ROCK_VALLEY, RED_ROCK);
		consumer.accept(BWGBiomes.RED_ROCK_PEAKS, RED_ROCK);
		consumer.accept(BWGBiomes.SKYRIS_VALE, SKYRIS);
		consumer.accept(BWGBiomes.WEEPING_WITCH_FOREST, SALEM);
	}

	private static ResourceKey<VillagerType> createKey(String name) {
		return BiomesWeveGone.key(Registries.VILLAGER_TYPE, name);
	}

	private static Supplier<VillagerType> register(String key) {
		return PlatformHandler.PLATFORM_HANDLER.register(BuiltInRegistries.VILLAGER_TYPE, key, () -> new VillagerType(key));
	}

	public static void villagerTypes() {
		BiomesWeveGone.LOGGER.info("Registering Oh The Biomes We've Gone villager types");
	}
}
