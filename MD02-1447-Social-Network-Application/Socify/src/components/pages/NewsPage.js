import React from 'react';
//CSS Libraries
import '@fortawesome/fontawesome-free/css/all.min.css';
import 'bootstrap-css-only/css/bootstrap.min.css';
import 'mdbreact/dist/css/mdb.css';
import { useDispatch, useSelector } from 'react-redux';
import { fetchNewsFeedPosts, clearPosts } from '../../store/slices/posts';
import PostsPage from './PostsPage';
import { useInfiniteScroll } from '../../hooks/useInfiniteScroll.js';
import styled from 'styled-components';

const NewsFeedLogo = styled.span`
color: #000;
font-family: 'Lobster', cursive;
letter-spacing: 0.2rem;
font-size: 9rem;
`;

function NewsPage() {
    const posts = useSelector(state => state.posts.posts);
    const cursor = useSelector(state => state.posts.cursor);
    const isLoading = useSelector(state => state.posts.isLoading);
    const dispatch = useDispatch();

    React.useEffect(() => {
        dispatch(clearPosts());
    }, [dispatch])

    const boundaryRef = useInfiniteScroll({
        onLoadMore: () => dispatch(fetchNewsFeedPosts()),
        isLoading,
        hasMore: !posts.length || cursor,
    });

    return (
        <>
            <div className="d-flex justify-content-center pt-4">
                <NewsFeedLogo>News feed</NewsFeedLogo>
            </div>
            <PostsPage posts={posts}></PostsPage>
            <div ref={boundaryRef}></div>
        </>
    );
}

export default NewsPage;