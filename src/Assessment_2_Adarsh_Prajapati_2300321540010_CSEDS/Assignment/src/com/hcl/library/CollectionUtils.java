package com.hcl.library;

import java.util.Comparator;
import java.util.List;

public class CollectionUtils {

    // Generic method to sort LibraryItem (or its subtypes) by Title, then by Year
    public static <T extends LibraryItem> void sortByTitleThenYear(List<T> items) {
        if (items == null) return;
        Comparator<LibraryItem> comparator = Comparator
                .comparing(LibraryItem::getTitle, String.CASE_INSENSITIVE_ORDER)
                .thenComparingInt(LibraryItem::getYear);
        items.sort(comparator);
    }
}
