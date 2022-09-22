package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.name, is("foo"));
  }

  @Test
  @DisplayName("Test that the quality is unchanged")
  void testQuality() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }
  @Test
  @DisplayName("Test update Value normal item")
  void testUpdateQualityItem() {
    Item items =
            new Item("item", 10, 50);
    GildedRose app = new GildedRose(new Item[] {items});
    app.updateQuality();
    assertThat(items.toString(),is("item, 9, 49"));
  }
  @Test
  @DisplayName("Test update Value normal item")
  void testUpdateQualityItemQualityUnder0() {
    Item items =
            new Item("item", 10, 0);
    GildedRose app = new GildedRose(new Item[] {items});
    app.updateQuality();
    assertThat(items.toString(),is("item, 9, 0"));
  }
  @Test
  @DisplayName("Test update Value Sulfuras, Hand of Ragnaros")
  void testUpdateQualitySulfurasSellinUnde0() {
    Item items =
            new Item("Sulfuras, Hand of Ragnaros", -1, 50);
    GildedRose app = new GildedRose(new Item[] {items});
    app.updateQuality();
    assertThat(items.toString(),is("Sulfuras, Hand of Ragnaros, -1, 50"));
  }
  @Test
  @DisplayName("Test update Value item")
  void testUpdateQualityItemSellinUnde0() {
    Item items =
            new Item("item", -1, 50);
    GildedRose app = new GildedRose(new Item[] {items});
    app.updateQuality();
    assertThat(items.toString(),is("item, -2, 48"));
  }
  @Test
  @DisplayName("Test update Value Aged Brie")
  void testUpdateQualityAgedBrie() {
    Item items =
            new Item("Aged Brie", 10, 50);
    GildedRose app = new GildedRose(new Item[] {items});
    app.updateQuality();
    assertThat(items.toString(),is("Aged Brie, 9, 50"));
  }
  @Test
  @DisplayName("Test update Value Aged Brie")
  void testUpdateQualityAgedBrieSellInUnder0QualityOver50() {
    Item items =
            new Item("Aged Brie", -1, 50);
    GildedRose app = new GildedRose(new Item[] {items});
    app.updateQuality();
    assertThat(items.toString(),is("Aged Brie, -2, 50"));
  }
  @Test
  @DisplayName("Test update Value Aged Brie, quality < 50")
  void testUpdateQualityAgedBrieQualityUnder50() {
    Item items =
            new Item("Aged Brie", 10, 49);
    GildedRose app = new GildedRose(new Item[] {items});
    app.updateQuality();
    assertThat(items.toString(),is("Aged Brie, 9, 50"));
  }
  @Test
  @DisplayName("Test update Value Aged Brie, sellin < 0")
  void testUpdateQualityAgedBrieSellInUnder50() {
    Item items =
            new Item("Aged Brie", -1, 48);
    GildedRose app = new GildedRose(new Item[] {items});
    app.updateQuality();
    assertThat(items.toString(),is("Aged Brie, -2, 50"));
  }
//  @Test
//  @DisplayName("Test update Value Sulfuras, sellin < 0")
//  void testUpdateQualitySulfurasSellInUnder0() {
//    Item items =
//            new Item("Sulfuras, Hand of Ragnaros", -1, 80);
//    GildedRose app = new GildedRose(new Item[] {items});
//    app.updateQuality();
//    assertThat(items.toString(),is("Sulfuras, Hand of Ragnaros, -1, 80"));
//  }
  @Test
  @DisplayName("Test update Value Backstage passes to a TAFKAL80ETC concert")
  void testUpdateQualityBackstage() {
    Item items =
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
    GildedRose app = new GildedRose(new Item[] {items});
    app.updateQuality();
    assertThat(items.toString(),is("Backstage passes to a TAFKAL80ETC concert, 9, 50"));
  }
  @Test
  @DisplayName("Test update Value Backstage passes to a TAFKAL80ETC concert")
  void testUpdateQualityBackstageSellInOver11() {
    Item items =
            new Item("Backstage passes to a TAFKAL80ETC concert", 12, 49);
    GildedRose app = new GildedRose(new Item[] {items});
    app.updateQuality();
    assertThat(items.toString(),is("Backstage passes to a TAFKAL80ETC concert, 11, 50"));
  }
  @Test
  @DisplayName("Test update Value Backstage passes to a TAFKAL80ETC concert")
  void testUpdateQualityBackstageExpired() {
    Item items =
            new Item("Backstage passes to a TAFKAL80ETC concert", -1, 49);
    GildedRose app = new GildedRose(new Item[] {items});
    app.updateQuality();
    assertThat(items.toString(),is("Backstage passes to a TAFKAL80ETC concert, -2, 0"));
  }
  @Test
  @DisplayName("Test update Value Backstage passes to a TAFKAL80ETC concert")
  void testUpdateQualityBackstageSellInUnder5() {
    Item items =
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 47);
    GildedRose app = new GildedRose(new Item[] {items});
    app.updateQuality();
    assertThat(items.toString(),is("Backstage passes to a TAFKAL80ETC concert, 3, 50"));
  }
}
