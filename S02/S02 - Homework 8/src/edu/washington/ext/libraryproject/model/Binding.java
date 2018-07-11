package edu.washington.ext.libraryproject.model;

/**
 * The Enum Binding that defines binding values for books.
 *
 */
public enum Binding {

    /** The HARDCOVER. */
    HARDCOVER("hardcover"),
    /** The PAPERBACK. */
    PAPERBACK("paperback"),
    /** The epub. */
    EPUB("epub"),
        /** The mobi. */
    MOBI("mobi"),
        /** The apk. */
    APK("apk");
    /** The binding type. */
    private String bindingType;

	/**
	 * Instantiates a new binding.
	 *
	 * @param bindingType
	 *            the binding type
	 */
	Binding(final String bindingType) {
		this.bindingType = bindingType;
	}

    /**
     * Gets the binding type.
     *
     * @return the bindingType
     */
    public String getBindingType() {
        return bindingType;
    }

}
