import React from 'react';

const useInfiniteScroll = ({ onLoadMore, isLoading, hasMore }) => {

    const boundaryRef = React.useRef();
    const onLoadMoreRef = React.useRef();

    onLoadMoreRef.current = onLoadMore;

    React.useEffect(() => {
        const intObserver = new IntersectionObserver(elements => {
            elements.forEach((elem) => {
                if (elem.isIntersecting) {
                    onLoadMoreRef.current();
                }
            });
        }, { rootMargin: '100px' });

        if (boundaryRef.current && !isLoading && hasMore) {
            intObserver.observe(boundaryRef.current);
        }

        return () => {
            intObserver.disconnect();
        }
    }, [isLoading, hasMore]);
    return boundaryRef;
}

export { useInfiniteScroll };