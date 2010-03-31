package com.browseengine.bobo.service;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import com.browseengine.bobo.api.BrowseFacet;
import com.browseengine.bobo.api.FacetAccessible;
import com.browseengine.bobo.api.FacetVisitor;
import com.browseengine.bobo.facets.impl.PathFacetIterator;

public class SerializedFacetAccessible implements FacetAccessible,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final List<BrowseFacet> _facets;
	public SerializedFacetAccessible(List<BrowseFacet> facets)
	{
		_facets = facets;
	}
	public BrowseFacet getFacet(String value) {
		for (BrowseFacet facet : _facets)
		{
			if (facet.getValue().equals(value))
				return facet;
		}
		return null;
	}

	public List<BrowseFacet> getFacets() {
		return _facets;
	}
  public void close()
  {
    // TODO Auto-generated method stub
    
  }
	
	public void visitFacets(FacetVisitor visitor) {
		for (BrowseFacet facet : _facets)
		{
			visitor.visit(facet.getValue(), facet.getHitCount());
		}		
	}
	
	public Iterator iterator() {
		return new PathFacetIterator(_facets);
	}

}
